package com.random.generator.controllers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ForwardControllerTest {

    ForwardController forwardController = new ForwardController();

    @Test
    void shouldRedirectToIndexHtmlWhenRequestWasMade() {
        // when
        String redirect = forwardController.redirect();

        // then
        Assertions.assertThat(redirect).isEqualTo("forward:/index.html");
    }

}
