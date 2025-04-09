// <dependency>
//     <groupId>org.springframework.boot</groupId>
//     <artifactId>spring-boot-starter-mail</artifactId>
// </dependency>



// spring.mail.host=smtp.gmail.com
// spring.mail.port=587
// spring.mail.username=your_email@gmail.com
// spring.mail.password=your_app_password
// spring.mail.properties.mail.smtp.auth=true
// spring.mail.properties.mail.smtp.starttls.enable=true




@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendExcelReport(String toEmail, String subject, String body, String excelFilePath) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(toEmail);
            helper.setSubject(subject);
            helper.setText(body);

            FileSystemResource file = new FileSystemResource(new File(excelFilePath));
            helper.addAttachment(file.getFilename(), file);

            mailSender.send(message);
            System.out.println("✅ Email sent successfully with attachment");

        } catch (MessagingException e) {
            e.printStackTrace();
            throw new RuntimeException("❌ Failed to send email: " + e.getMessage());
        }
    }
// }
// ✅ Step 4: Use in Your Service Layer
// In DailyReportsServiceImpl.java:


@Autowired
private EmailService emailService;

public void generateExcelAndSendMail(LocalDate date) {
    List<DailyReports> reports = drRepo.findByDate(date);
    String excelFilePath = ExcelGeneratorUtil.generateExcel(reports);

    emailService.sendExcelReport(
            "A@gmail.com",                            // recipient
            "Daily Report for " + date,               // subject
            "Please find attached the daily report.", // body
            excelFilePath                             // attachment path
    );
}









