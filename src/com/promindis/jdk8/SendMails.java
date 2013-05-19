package com.promindis.jdk8;

public class SendMails implements Mailing, Runnable {


  public static void main(final String[] args) {
    new SendMails().run();
  }

  @Override
  public void run() {
    send(mailer -> mailer.from("build@agiledeveloper.com")
        .to("venkats@agiledeveloper.com")
        .subject("build notification")
        .body("...much better..."));
  }
}
