package co.spoonradio.sims.component.aws.ses

import co.spoonradio.arch.logger.Logger
import co.spoonradio.sims.configuration.properties.sims.SimsEnvInfo
import co.spoonradio.sims.service.adminuser.AdminUserInfoManager
import org.springframework.stereotype.Component
import software.amazon.awssdk.services.ses.SesClient
import software.amazon.awssdk.services.ses.model.*

@Component
class SesManager(
    val sesClient: SesClient,
    val simsEnvInfo: SimsEnvInfo,
) {
    companion object : Logger

    fun sendMail(fileUrl:String, fileName:String):String {
        val FROM = simsEnvInfo.adminEmail
        val SUBJECT = "File download - SIMS";

        val subject: Content = Content.builder()
            .data(SUBJECT)
            .build()
        val content: Content = Content.builder()
            .data(this.mailContents(fileUrl, fileName))
            .build()
        val message = Message.builder()
            .subject(subject)
            .body(Body.builder()
                .html(content)
                .build())
            .build()

        sesClient.sendEmail(SendEmailRequest.builder()
            .destination(Destination.builder()
                .toAddresses(AdminUserInfoManager.getUserInfo().email)
                .build()
            )
            .message(message)
            .source(FROM)
            .build())
        return "OK"
    }

    private fun mailContents(fileUrl:String, fileName:String) : String {
        return """
            <html class="no-js">
            <head>
                <meta charset="utf-8">
                <title>SIMS V3 - download</title>
                <meta name="viewport" content="initial-scale=1.0, user-scalable=no, width=device-width">
                <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
            </head>

            <body style="margin: 0;">
            <div style="position:relative; max-width:720px; padding:0; margin:0 auto; font-size:13px; color:#343a40;">
                <div style="margin:0; padding:0;">
                    <img src="https://www.spooncast.net/static/edm/images/logo@2x.png" style="width:100px; border:0; vertical-align:top; margin:40px 0; padding:0;" />
                    <h2 style="color: #353a41;">SIMS V3 download</h2>
                </div>              
                <table border="0">
                <tr>                    
                    <td align="left" bgcolor="#008000" width="20" style="border-radius: 5px;">
                        <p style="color:#ffffff;text-align: center; ">X</p>
                    </td>
                    <td align="left" width="240">
                        <p style="font-size:18;">${fileName}</p>
                    </td>
                </tr>    
                <tr><td></td></tr>
                <tr>
                    <td align="center" bgcolor="#ff4100" width="300" style="border-radius: 20px;" colspan="2">
                        <a href="${fileUrl}" style="padding: 10px; width:150px; text-decoration: none; border:0;text-align: center; font-weight: bold; font-size: 20px; color: #ffffff; background: #ff4100;border: 1px solid #ff4100; line-height:50px;" >Download</a>
                    </td>
                </tr>
                <tr>
                    <td align="center" width="300" colspan="2">
                        <p style="font-size:15px;">Click the button to go to the download page.</p>
                    </td>
                </tr>
                </table>                
            </div>
            </body>
            </html>
        """
    }
}