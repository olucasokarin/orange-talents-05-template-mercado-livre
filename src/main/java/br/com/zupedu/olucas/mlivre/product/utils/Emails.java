package br.com.zupedu.olucas.mlivre.product.utils;

import br.com.zupedu.olucas.mlivre.product.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Component
public class Emails {
    @Autowired
    Mailer mailer;

    public void newQuestion(@NotNull @Valid Question question) {
        mailer.send("<html> <body> body of question </body> </html>",
                "New question about to product",
                question.getUsernameFromQuestion(),
                "question@emailivre.com",
                question.getUsernameFromProduct());
    }
}
