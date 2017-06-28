package nz.co.midori.backend.core.services;

import com.sendgrid.*;
import nz.co.midori.backend.core.model.ApplicationUser;
import nz.co.midori.frontend.model.ContactModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.logging.Logger;

/**
 * Created by djunigari on 9/05/17.
 */
@Service
public class MailSender {
    Logger log = Logger.getLogger("MailSender");
    @Value("${app.sender-mail.email}")
    private String EMAIL;
    private static Email FROM;
    @Value("${app.sender-mail.api-key}")
    private String API_KEY;

    public void sendMail(String email,String subject, String content){
        Email to = new Email(email);
        Mail mail = new Mail(FROM, subject, to, new Content("text/html", content));

        SendGrid sg = new SendGrid(API_KEY);
        Request request = new Request();
        try {
            request.method = Method.POST;
            request.endpoint = "mail/send";
            request.body = mail.build();
            Response response = sg.api(request);
            log.info("Status Code: "+response.statusCode);
            log.info("Body: "+response.body);
            log.info("Headers: "+response.headers);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void sendMail(ContactModel contactModel){
        String subject = "[My International Education] Contact Us Email";
        String content ="━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━<br>\n" +
                "<strong>[My International Education] Contact Us Email</strong><br>\n" +
                "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━<br>\n" +
                "<br>\n" +
                "<strong>Email:</strong> "+ contactModel.getEmail()+"<br>\n" +
                "<strong>Phone/Mobile:</strong> "+ contactModel.getPhone()+"<br>\n" +
                "<strong>Last Name:</strong> "+ contactModel.getLastName()+"<br>\n" +
                "<strong>First Name:</strong> "+ contactModel.getFirstName()+"<br>\n" +
                "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━<br>\n" +
                "<strong>Subject:</strong> "+ contactModel.getSubject()+"<br>\n" +
                "<strong>Message:</strong> <br>"+ contactModel.getMessage();

        sendMail(EMAIL,subject,content);

        log.info("Task: sendEmail, Result: Success, Email: "+EMAIL+", ContactModel="+contactModel);
    }

    public void authenticationEmail(ApplicationUser user, String code){
        String subject = "[My International Education] Authentication Instructions";
        String content ="Hello and welcome to Keducation!" +
                        "<br><br>" +
                        "You have registered with Keducation, and now please verify your Keducation account by clicking the link below:" +
                        "<br><br>"+
                        "<a href=\"http://www.keducation.co.nz/user/"+ user.getUserId() +"/activate?code="+code+"\" target=\"_blank\" rel=\"noopener noreferrer\" id=\"LPlnk978850\" previewinformation=\"1\">www.keducation.co.nz</a>" +
                        "<br><br>" +
                        "Thank you and we are looking forward to having your say!" +
                        "<br><br>" +
                        "Best regards" +
                        "<br>"+
                        "<strong>Keducation Administration</strong>";
        sendMail(user.getEmail(),subject,content);

        log.info("Task: sendEmail, Result: Success, Email: "+user.getEmail()+", user: "+user);
    }

    public void forgettenPassword(String email, String user,String code) {
        String subject = "[My International Education] Reset Password Instructions";
        String content ="━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━<br>\n" +
                "[My International Education] Reset Password Instructions<br>\n" +
                "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━<br>\n" +
                "<br>\n" +
                "[Visit the URL below to reset your password]<br>\n" +
                "<a href=\"http://www.keducation.co.nz/register/user/reset-password?code="+code+"\" target=\"_blank\" rel=\"noopener noreferrer\" id=\"LPlnk978850\" previewinformation=\"1\">www.keducation.co.nz</a><br>\n" +
                "<br>\n" +
                "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━<br>";
        sendMail(email,subject,content);

        log.info("Task: sendEmail, Result: Success, Email: "+email+", UserName: "+user);
    }

    @Value("${app.sender-mail.noreply-email}")
    public void setFrom(String email){
        this.FROM = new Email(email);
    }
}
