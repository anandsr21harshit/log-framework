public class PaymentService {

    private static final Logger logger = LoggerManager.getLogger(PaymentService.class);

    public void processPayment(){
        logger.info("Processing Payment...");

        try{
            // callBankServer()
            logger.debug("Bank server called");
        }catch (Exception ex){
            logger.error("Exception occurred");
        }
    }
}
