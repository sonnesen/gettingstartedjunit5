package patientintake.notifier;

import java.util.ArrayList;
import java.util.List;

public class EmailNotifierDouble implements EmailNotifier {

    List<Message> receivedMessages = new ArrayList<>();
    @Override
    public void sendNotification(String subject, String body, String address) {
        receivedMessages.add(new Message(subject, body, address));
    }

    class Message {
        private final String toAddress;
        private final String subject;
        private final String body;

        public Message(String subject, String body, String address) {
            this.subject = subject;
            this.body = body;
            this.toAddress = address;
        }

        public String getToAddress() {
            return toAddress;
        }

        public String getSubject() {
            return subject;
        }

        public String getBody() {
            return body;
        }
    }
}
