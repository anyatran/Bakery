package bakery;

/**
 * Manages customer loyalty cards
 * @author rcj, anhtran9
 * @version 06/17/14
 */
public class LoyaltyCard {
    /** Whether or not this customer has a loyalty card */
    private boolean activated;
    /** 100 - points = $$$ remaining until customer gets next reward */
    private Double points;
    /** The dollar amount the customer has available from past rewards */
    private Double reward;
    
    /**
     * Default constructor
     */
    LoyaltyCard() {
        this.activated = false;
        this.points = 0.0;
        this.reward = 0.0;
    }
    
    /**
     * Constructor for updating an existing loyalty card
     * @param activated
     *        Whether or not this customer has a loyalty card
     * @param points
     *        100 - points = $$$ remaining until customer gets next reward
     * @param reward
     *        The dollar amount the customer has available from past rewards
     */
    public LoyaltyCard(boolean activated, Double points, Double reward) {
        this.activated = activated;
        this.points = points;
        this.reward = reward;
    }

    /**
     * Get the reward amount for this card
     * @return The reward amount for this card
     */
    public Double getReward() {
        return this.reward;
    }
    
    /**
     * Get the points available on this card
     * @return The points available on this card
     */
    public Double getPoints() {
        return this.points;
    }

    /**
     * Apply reward to a purchase
     * @param amt
     *        The amount of the reward to apply to the purchase
     */
    void deductReward(double amt) {
        this.reward -= amt;
    }

    /**
     * Set the reward available to zero when it is exhausted
     */
    void clearReward() {
        this.reward = 0.0;
    }

    /**
     * Update the card after a purchase
     * @param total
     *        The amount of the purchase
     */
    void updateCard(double total) {
        this.reward = Math.floor((total + this.points) / 100) * 10;
        this.points = (total + this.points) % 100;
    }

    /**
     * A string representation of the loyalty card
     * @return A string representation of the loyalty card
     */
    public String toString() {
        if (!this.activated) {
            return "the card is not activated";
        }
        else {
            return "Status: activated" + "\n" + "Points: " +
                    this.points.toString() + "\n" + "Reward: " + 
                    this.reward.toString();
        }

    }


}
