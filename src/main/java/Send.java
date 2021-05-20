import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import org.json.JSONObject;


public class Send {

    public static void main(String[] args){

        /*
            Region Credentials: us-east-2
         */
        AmazonSQS sqs = AmazonSQSClientBuilder.standard().build();

        //Creates the Queue and captures URL
        Create createUrl = new Create("Queue1");
        String queueUrl = createUrl.getURL();

        //creates JSON object and appends values
        JSONObject jsonObject = new JSONObject("{ \"Queue Type\" : \"Standard\" }");
            jsonObject.put("Message", "AWS SQS");
            jsonObject.put("Bank:", "TD");
            jsonObject.put("Transaction Type", "Credit");
            jsonObject.put("Amount:", 50);
            jsonObject.append("Pending Transactions:", 25);
            jsonObject.append("Pending Transactions:", 23);
            jsonObject.append("Pending Transactions:", 98);


        // Perform various tasks on the Amazon SQS queue
        SendMessageRequest sendMessageRequest = new SendMessageRequest()
                .withQueueUrl(queueUrl)
                .withMessageBody(jsonObject.toString());
        sqs.sendMessage(sendMessageRequest);


    }
}
