/* For business logic related to campaigns */
class CampaignManager {
    public void startCampaign(AdsAccount account) {
        // Logic to start a new campaign...
        System.out.println("Campaign started.");
    }
}

/* For handling data persistence */
class AdsAccountRepository {
    public void save(AdsAccount account) {
        // Logic to save the account state to a database...
        System.out.println("Account saved to database.");
    }
}

/* For calculating statistics */
class CampaignAnalytics {
    public void calculateCampaignStats(AdsAccount account) {
        // Logic to calculate and report stats...
        System.out.println("Calculating campaign stats.");
    }
}

// The AdsAccount class now only holds data (state)
class AdsAccount {
    // Properties like accountId, campaignName, budget, etc.
}