import { Component, OnInit }                  from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { GeneratorService }                   from '../generator.service';
import { first }                              from 'rxjs/operators';

@Component({
  selector: 'app-uuids-generator',
  templateUrl: './uuids-generator.component.html',
  styleUrls: ['./uuids-generator.component.css']
})
export class UuidsGeneratorComponent implements OnInit {

  uuidForm: FormGroup;
  loading = false;
  submitted = false;
  generatedUUIDs: string[];

  constructor(private formBuilder: FormBuilder,
              private generator: GeneratorService) {
  }

  ngOnInit(): void {
    this.uuidForm = this.formBuilder.group({
      howManyNumbers: ['', Validators.required],
    });
  }

  onSubmit(): void {
    this.submitted = true;
    this.loading = true;
    this.generator.getGeneratedUUIDs(this.uuidForm.value.howManyNumbers)
      .pipe(first())
      .subscribe(
        (value) => {
          this.generatedUUIDs = value;
        },
        error => {
          console.log('Error');
        });
  }

}
