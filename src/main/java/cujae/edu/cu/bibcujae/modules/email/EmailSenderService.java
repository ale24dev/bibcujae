package cujae.edu.cu.bibcujae.modules.email;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

@Service
public class EmailSenderService {

    @Autowired
    private  JavaMailSender emailSender;

    @Autowired
    private  Configuration freemarkerConfig;

    public void sendEmail(Mail mail) throws MessagingException, IOException, TemplateException {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,
                MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                StandardCharsets.UTF_8.name());

        Template t = freemarkerConfig.getTemplate(mail.getTemplate());
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, mail.getProps());

        helper.setTo(mail.getMailTo());
        helper.setText(html, true);
        helper.setSubject(mail.getSubject());
        helper.setFrom(new InternetAddress("pweb@cujae.edu.cu", "Pweb-notificaciones"));

        emailSender.send(message);
    }

    public void sendEmailToUserWithCredentials(String fullname, String email) {
        Mail mail = new Mail();
        mail.setMailTo(email);
        mail.setSubject("Registro de usuario");
        mail.setTemplate("user-registration-template.ftl");

        Map<String, Object> model = new HashMap<String, Object>();

        model.put("name", fullname);
        mail.setProps(model);
        System.out.println("paso");
        try {
            sendEmail(mail);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}