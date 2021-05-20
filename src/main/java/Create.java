import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.CreateQueueRequest;


public class Create {

    String queueURL;

    /**
     * Creates  the Queue in AWS SQS
     * @param queueName
     */
    public Create(String queueName){
        AmazonSQS sqs = AmazonSQSClientBuilder.standard().build();
        final CreateQueueRequest createQueueRequest = new CreateQueueRequest(queueName);
        final String myQueueUrl = sqs.createQueue(createQueueRequest).getQueueUrl();
        queueURL = myQueueUrl;
    }

    /**
     * Getter Method to return Newly Create Queue Url
     * @return queueURL
     */
    public String getURL(){
        return queueURL;
    }


}
