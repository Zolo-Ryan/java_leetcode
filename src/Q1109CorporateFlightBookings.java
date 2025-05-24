public class Q1109CorporateFlightBookings {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] arr = new int[n];
        for(int i = 0; i < bookings.length; i++){
            arr[bookings[i][0] - 1] += bookings[i][2]; // arr[left] += val
            if(bookings[i][1] - 1 < n-1) arr[bookings[i][1] - 1 + 1] -= bookings[i][2]; // arr[right+1] -= val
        }
        int sum = 0;
        for (int i = 0;i<n;i++){
            sum += arr[i]; // sum leta ja aur arr me daal de
            arr[i] = sum;
        }
        return arr;
    }
}
