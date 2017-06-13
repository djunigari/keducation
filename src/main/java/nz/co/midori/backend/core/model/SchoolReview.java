package nz.co.midori.backend.core.model;


import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by djunigari on 22/05/17.
 */
public class SchoolReview {
    private School school;
    private double score;
    private long totalReviews;
    private double qualityScore = 0;
    private double comfortScore = 0;
    private double locationScore = 0;
    private double priceScore = 0;
    private double supportScore = 0;
    private double recommendation = 0;
    private List<Review> reviewList;

    public SchoolReview(School school, double score, long totalReviews) {
        this.school = school;
        this.score = score;
        this.totalReviews = totalReviews;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public double getScore() {
        return round(score);
    }

    public void setScore(double score) {
        this.score = score;
    }

    public long getTotalReviews() {
        return totalReviews;
    }

    public void setTotalReviews(long totalReviews) {
        this.totalReviews = totalReviews;
    }

    public double getQualityScore() {
        return round(qualityScore);
    }

    public void setQualityScore(double qualityScore) {
        this.qualityScore = qualityScore;
    }

    public double getComfortScore() {
        return round(comfortScore);
    }

    public void setComfortScore(double confortScore) {
        this.comfortScore = confortScore;
    }

    public double getLocationScore() {
        return round(locationScore);
    }

    public void setLocationScore(double locationScore) {
        this.locationScore = locationScore;
    }

    public double getPriceScore() {
        return round(priceScore);
    }

    public void setPriceScore(double priceScore) {
        this.priceScore = priceScore;
    }

    public double getSupportScore() { return round(supportScore); }

    public void setSupportScore(double support1Score) {
        this.supportScore = support1Score;
    }

    public List<Review> getReviewList() {
        return reviewList;
    }

    public void setReviewList(List<Review> reviewList) {
        this.reviewList = reviewList;
    }

    public double getRecommendation() {
        return getPercent(recommendation);
    }

    public void setRecommendation(double recommendation) {
        this.recommendation = recommendation;
    }

    @Override
    public String toString() {
        return "SchoolReview{" +
                "school=" + school +
                ", score=" + score +
                ", totalReviews=" + totalReviews +
                ", qualityScore=" + qualityScore +
                ", comfortScore=" + comfortScore +
                ", locationScore=" + locationScore +
                ", priceScore=" + priceScore +
                ", supportScore=" + supportScore +
                ", recommendation=" + recommendation +
                ", reviewList=" + reviewList +
                '}';
    }

    private double round(double val){
        DecimalFormat df2 = new DecimalFormat("###.##");

        return Double.valueOf(df2.format(val));
    }

    private double getPercent(double score){
        if(totalReviews == 0){
            return 0.00;
        }
        return round(score*100/totalReviews);
    }
}
