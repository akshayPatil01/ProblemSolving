import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MeetingsInRoom {
    public static void main(String[] args) {
        int[] start = new int[]{1, 3, 0, 5, 8, 5};
        int[] end = new int[]{2, 4, 6, 7, 9, 9};
        int n = start.length;

        MeetingsInRoom m = new MeetingsInRoom();
        System.out.println("Max number of meetings can be held in room: " + m.maxMeetings(n, start, end));
    }

    public int maxMeetings(int n, int[] start, int[] end) {

        List<Meeting> meetings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            meetings.add(new Meeting(start[i], end[i]));
        }

        meetings.sort(Comparator.comparingInt(m -> m.end));

        int count = 0;
        int lastEndTime = -1;

        for (Meeting meet : meetings) {
            if (meet.start > lastEndTime) {
                count++;
                lastEndTime = meet.end;
            }
        }

        return count;
    }


    private static class Meeting {
        int start;
        int end;

        Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
