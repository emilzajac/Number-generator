import { Component, OnInit }                  from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { GeneratorService }                   from '../generator.service';
import { first }                              from 'rxjs/operators';

@Component({
  selector: 'app-integers-generator',
  templateUrl: './integers-generator.component.html',
  styleUrls: ['./integers-generator.component.css']
})
export class IntegersGeneratorComponent implements OnInit {

  integersForm: FormGroup;
  loading = false;
  submitted = false;
  generatedNumbers: number[];

  constructor(private formBuilder: FormBuilder,
              private generator: GeneratorService) {
  }

  ngOnInit(): void {
    this.integersForm = this.formBuilder.group({
      min: ['', Validators.required],
      max: ['', Validators.required],
      howManyNumbers: ['', Validators.required],
    });
  }

  onSubmit(): void {
    this.submitted = true;
    this.loading = true;
    this.generator.getGeneratedNumbers(this.integersForm.value.min, this.integersForm.value.max, this.integersForm.value.howManyNumbers)
      .pipe(first())
      .subscribe(
        (value) => {
          this.generatedNumbers = value;
        },
        error => {
          console.log('Error');
        });
  }

}
