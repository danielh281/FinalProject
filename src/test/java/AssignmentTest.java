import org.dh.Assignment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AssignmentTest {
    @Test
    @DisplayName("calcAssignmentAvg: 100, 75, 80 -> 85")
    void calcAssignmentAvgTest1() {
        Assignment assignment = new Assignment(null, -1);

        Integer score1 = 100;
        Integer score2 = 75;
        Integer score3 = 80;

        assignment.getScores().add(score1);
        assignment.getScores().add(score2);
        assignment.getScores().add(score3);

        double expected = 85;
        double result = assignment.calcAssignmentAvg();

        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("calcAssignmentAvg: 100 -> 100")
    void calcAssignmentAvgTest2() {
        Assignment assignment = new Assignment(null, -1);

        Integer score1 = 100;

        assignment.getScores().add(score1);

        double expected = 100;
        double result = assignment.calcAssignmentAvg();

        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("calcAssignmentAvg: 100, null -> 50")
    void calcAssignmentAvgTest3() {
        Assignment assignment = new Assignment(null, -1);

        Integer score1 = 100;
        Integer score2 = null;

        assignment.getScores().add(score1);
        assignment.getScores().add(score2);

        double expected = 50;
        double result = assignment.calcAssignmentAvg();

        Assertions.assertEquals(expected, result);
    }
}
