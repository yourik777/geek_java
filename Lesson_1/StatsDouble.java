package Lesson_1;

public class StatsDouble {
    private Double[] nums;

    public StatsDouble(Double[] nums) {
        this.nums = nums;
    }

    public double avg() {
        double sum = 0.0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i].doubleValue();
        }

        return sum / nums.length;
    }
}
