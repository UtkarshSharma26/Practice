package com.practice;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordDetector {

    public static void main(String[] args) {

        int num = 98765;
        patterPrintingOptimised(num);
//        System.out.println();
//        patterPrintingReverseOptimised(num);

//        sockMerchant(7, Arrays.asList(10, 20, 20, 10, 10, 30, 50, 10, 20));
//        countingValleys(8, "UDDDUDUU");
//        jumpingOnClouds(Arrays.asList(0, 0, 1, 0, 0, 1, 0));
//        jumpingOnClouds(Arrays.asList(0,0,0,0,1,0));
//        repeatedString("abacabacaba", 11);
//        longestSubarray(Arrays.asList(1, 2, 3, 4, 5));
//        twoStrings("hello", "world");
//        makeAnagram("cde", "abc");
//        checkMagazine(Arrays.asList("apgo", "clm", "w", "lxkvg", "mwz" ,"elo" ,"bg", "elo", "lxkvg", "elo", "apgo", "apgo", "w", "elo", "bg"),Arrays.asList("elo", "lxkvg", "bg", "mwz", "clm", "w"));
//        alternatingCharacters("AABAAB");
//        sherlockValidString("aabbc");
//        substrCount(7, "abcbaba");
//        int[] arr = {3, 7, 90, 20, 10, 50, 40};
//        findLeastAvgSubArray(arr, 3);
//        replaceNWithEvenSquares(arr, 20);
//        rotateLeft(2, Arrays.asList(1, 2, 3, 4, 5));
//        matchingStrings(Arrays.asList("ab", "ab", "abc"), Arrays.asList("ab", "abc", "bc"));
//        bonAppetit(Arrays.asList(3, 10, 2, 9), 1, 12);
//        getTotalGoalsRESTAPI("Barcelona", 2011);
//        bestDivisor(198);
//        activityNotifications(Arrays.asList(10, 20, 30, 40, 50), 3);
//        maxDifferenceProductOfString("aaabc");
//        secondLargestNumber(new int[]{12, 35, 1, 10, 34, 1, 55});
//        getListOfDigitsFromNumber(123);
//        reverseWithoutAffectingSpecialCharacters("sun@rise");
//        StringBuffer sb = new StringBuffer("nishant");
//        String s = "nishant";
//        System.out.println(s);
//        getTimeZone(sb, s);
//        System.out.println(s);

//        wordDetect();
//        rainForest();
//        HashSet<Integer> ser = new HashSet<>();
//        ser.add(2);
//        ser.add(1);
//        ser.add(2);
//        ser.add(3);
//        ser.forEach(System.out::println);
//        HashSet<Ques> s = new HashSet<>();
//        s.add(new Ques(2));
//        s.add(new Ques(1));
//        s.add(new Ques(2));
//        s.add(new Ques(3));
//        s.forEach(System.out::println);
    }

    public static void findCount(String number)
    {

        // Calculate the sum
        int sum = 0;
        for (int i = 0; i < number.length(); ++i) {
            sum += number.charAt(i) - 48;
        }

        // Store the answer
        int count = 0;
        if (sum % 3 == 0)
            count++;

        // Iterate over the range
        for (int i = 0; i < number.length(); ++i) {

            // Decreasing the sum
            int remaining_sum
                    = sum - (number.charAt(i) - 48);

            // Iterate over the range
            for (int j = 0; j <= 9; ++j) {

                // Checking if the new sum
                // is divisible by 3 or not
                if ((remaining_sum + j) % 3 == 0
                        && j != number.charAt(i) - 48) {

                    // If yes increment
                    // the value of the count
                    ++count;
                }
            }
        }
        System.out.println(count);
    }

    public static Map<Integer, Integer> getPairWithKSum(List<Integer> nums, int k) {
        Map<Integer, Integer> pairs = new HashMap<>();
        Set<Integer> numSet = new HashSet<>(nums);
        numSet.forEach(n -> {
            if (nums.contains(Math.abs(k - n)) && n != Math.abs(k - n)) {
                pairs.put(n, Math.abs(k - n));
            }
        });
        return pairs;
    }

    public static List<Integer> spyNumbers(int start, int end) {
        List<Integer> spyList = new ArrayList<>();
        for (int i = start; i < 11; i++) {
            spyList.add(i);
        }
        for (int i = 11; i < end; i++) {
            if (sum(i) == prod(i)) spyList.add(i);
        }
        System.out.println(spyList);
        return spyList;
    }

    private static int prod(int i) {
        final int[] prod = {1};
        Arrays.stream(String.valueOf(i).split("")).collect(Collectors.toList()).forEach(f -> prod[0] *= Integer.valueOf(f));
        return prod[0];
    }

    private static int sum(int i) {
        final int[] sum = {0};
        Arrays.stream(String.valueOf(i).split("")).collect(Collectors.toList()).forEach(f -> sum[0] += Integer.valueOf(f));
        return sum[0];
    }

    public static String reverseWithoutAffectingSpecialCharacters(String str) {
        char[] chars = str.toCharArray();
        int last = chars.length - 1, first = 0;
        while (first < last) {
            if (!Character.isAlphabetic(chars[first])) first++;
            else {
                if (Character.isAlphabetic(chars[last])) {
                    char temp = chars[first];
                    chars[first] = chars[last];
                    chars[last] = temp;
                    first++;
                }
                last--;
            }
        }
        return String.valueOf(chars);
    }

    public static List<Integer> getListOfDigitsFromNumber(int number) {
        return Arrays.stream(String.valueOf(number).split("")).map(m -> Integer.valueOf(m)).collect(Collectors.toList());
    }

    public static int secondLargestNumber(int[] numArray) {
        int first = 0, second = 0;
        for (int ithdigit : numArray) {
            if (ithdigit > first) {
                second = first;
                first = ithdigit;
            } else if (ithdigit > second && ithdigit != first) second = ithdigit;
        }
        return second;
    }

    public static int maxDifferenceProductOfString(String s) {
        List<String> sList = new ArrayList<>(Arrays.asList(s.split("")));
        Map<String, Long> sFreqMap = sList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        final int[] prod1 = {0};
        sFreqMap.values().forEach(f -> prod1[0] *= f);

        int prod2 = 0;
        return prod2 - prod1[0];
    }

    public static int activityNotifications(List<Integer> expenditure, int d) {
        int count = 0;
        for (int i = d; i < expenditure.size(); i++) {
            long median = getMedian(expenditure.subList(0, i));
            if (expenditure.get(i) >= 2 * median) count++;
        }
        System.out.println(count);
        return count;
    }

    private static long getMedian(List<Integer> subList) {
        List<Integer> sortedList = subList.stream().sorted().collect(Collectors.toList());
        int size = sortedList.size();
        if (size % 2 == 0) return (sortedList.get(size / 2) + sortedList.get((size / 2) + 1)) / 2;
        else return sortedList.get((size / 2));
    }

    public static int bestDivisor(int number) {
        Map<Integer, Integer> divisorsSum = new HashMap<>();
        for (int i = 1; i <= number; i++)
            if (number % i == 0 && !divisorsSum.containsKey(getSumOfDigits(i))) divisorsSum.put(getSumOfDigits(i), i);
        return divisorsSum.get(divisorsSum.keySet().stream().sorted().collect(Collectors.toList()).get(divisorsSum.size() - 1));
    }

    private static int getSumOfDigits(int num) {
        int sum = 0, digit = 0;
        while (num > 0) {
            digit = num % 10;
            sum += digit;
            num /= 10;
        }
        return sum;
    }


    public static int getTotalGoalsRESTAPI(String team, int year) throws IOException, ScriptException {
        final String endpoint = "https://jsonmock.hackerrank.com/api/football_matches";
        int totalHomeGoals = getPageTotalGoals(String.format(endpoint + "?year=%d&team1=%s", year, URLEncoder.encode(team, StandardCharsets.UTF_8)), 0, "team1", 1);
        int totalVisitingGoals = getPageTotalGoals(String.format(endpoint + "?year=%d&team2=%s", year, URLEncoder.encode(team, StandardCharsets.UTF_8)), 0, "team2", 1);
        return totalHomeGoals + totalVisitingGoals;
    }

    private static int getPageTotalGoals(String request, int totalGoals, String team, int page) throws IOException, ScriptException {
        URL url = new URL(request + "&page=" + page);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setConnectTimeout(5000);
        httpURLConnection.setReadTimeout(5000);
        httpURLConnection.addRequestProperty("Content-Type", "application/json");
        int httpStatus = httpURLConnection.getResponseCode();
        InputStream inputStream = (httpStatus < 200 || httpStatus > 299) ? httpURLConnection.getErrorStream() : httpURLConnection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String responseText;
        StringBuffer responseContent = new StringBuffer();
        while ((responseText = bufferedReader.readLine()) != null) responseContent.append(responseText);
        bufferedReader.close();
        httpURLConnection.disconnect();
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("javascript");
        String script = "var obj = JSON.parse('" + responseContent + "');";
        script += "var total_pages = obj.total_pages;";
        script += "var total_goals = obj.data.reduce(function(accumulator,current){return accumulator + parseInt(current." + team + "goals);},0)";
        scriptEngine.eval(script);
        if (scriptEngine.get("total_pages") == null)
            throw new RuntimeException("Cannot retrieve data from the server.");
        int totalPages = (int) scriptEngine.get("total_pages");
        totalGoals += (int) Double.parseDouble(String.valueOf(scriptEngine.get("total_goals")));
        return (page < totalPages) ? getPageTotalGoals(request, totalGoals, team, page + 1) : totalGoals;
    }

    public static void bonAppetit(List<Integer> bill, int notEaten, int shareCalculated) {
        final int[] total = {0};
        bill.forEach(f -> total[0] += f);
        int actualShare = (total[0] - bill.get(notEaten)) / 2;
        if (shareCalculated == actualShare) System.out.println("Bon Appetit");
        else System.out.println(shareCalculated - actualShare);
    }

    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
        List<Integer> frequency = new ArrayList<>();
        queries.forEach(q -> frequency.add(Math.toIntExact(strings.stream().filter(f -> f.equals(q)).count())));
        return frequency;
    }

    public static List<Integer> rotateLeft(int d, List<Integer> arr) {
        List<Integer> rotatedList = new ArrayList<>(arr);
        for (int i = 0; i < d; i++) {
            rotatedList.add(arr.get(i));
            rotatedList.remove(arr.get(i));
        }
        return rotatedList;
    }

    static void findLeastAvgSubArray(int[] arr, int k) {
        int start = 0;
        int end = k;
        int avg = 0;
        for (int i = 0; i < k; i++) avg += arr[i];
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < i + k; j++) {
                if (j + k < arr.length) {
                    int sum = 0;
                    sum += arr[j];
                    if (sum < avg) {
                        start = j;
                        end = j + k - 1;
                    }
                }
            }
        }
        System.out.println("Start -> " + start + " End -> " + end);
    }

    static void replaceNWithEvenSquares(int[] arr, int n) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == n) for (int j = i; j < arr.length; j++) if (arr[j] % 2 == 0) arr[i] += arr[j] * arr[j];
        for (int j : arr) System.out.print(j + "  ");
    }

    public static long substrCount(int n, String s) {
        return getPalindromeSubStringList(s, n).size();
    }

    public static List<String> getPalindromeSubStringList(String str, int n) {
        List<String> subStrings = new ArrayList<>();
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j <= n; j++)
                if (i - j == 1) subStrings.add(str.substring(i, j));
                else if (isPalindrome(str.substring(i, j))) subStrings.add(str.substring(i, j));
        return subStrings;
    }

    public static boolean isPalindrome(String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        return str.equals(sb.toString());
    }

    public static String sherlockValidString(String s) {
        if (s.isEmpty()) return "NO";
        if (s.length() <= 3) return "YES";
        List<String> sList = new ArrayList<>(Arrays.asList(s.split("")));
        Map<String, Long> sFreqMap = sList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        long uniqueCount = sFreqMap.values().stream().distinct().count();
        if (uniqueCount == 1) return "YES";
        else if (uniqueCount > 2) return "NO";
        return "NO";
    }

    public static int alternatingCharacters(String s) {
        int count = 0;
        char[] sChar = s.toCharArray();
        for (int i = 0; i < sChar.length - 1; i++) if (sChar[i] == sChar[i + 1]) count++;
        return count;
    }

    public static void checkMagazine(List<String> magazine, List<String> note) {
        if (magazine.size() < note.size()) System.out.println("No");
        else {
            boolean result = true;
            Map<String, Long> magazineFrequencyMap = magazine.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            Map<String, Long> noteFrequencyMap = note.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            for (Map.Entry<String, Long> entry : noteFrequencyMap.entrySet()) {
                String key = entry.getKey();
                Long value = entry.getValue();
                if (!(magazineFrequencyMap.containsKey(key) && magazineFrequencyMap.get(key) >= value)) {
                    result = false;
                    break;
                }
            }
            System.out.println(result ? "Yes" : "No");
        }
    }

    public static int makeAnagram(String a, String b) {
        int count = 0;
        char[] first = a.toCharArray();
        char[] second = b.toCharArray();
        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                if (first[i] == second[j]) {
                    second[j] = 0;
                    count++;
                    break;
                }
            }
        }
        return a.length() + b.length() - 2 * (count);
    }

    public static String twoStrings(String s1, String s2) {
        Set<String> s1Set = new HashSet<>(Arrays.asList(s1.split("")));
        Set<String> s2Set = new HashSet<>(Arrays.asList(s2.split("")));
        Set<String> mergeSet = new HashSet<>(s1Set);
        mergeSet.addAll(s2Set);
        return mergeSet.size() == s1Set.size() + s2Set.size() ? "NO" : "YES";
    }

    public static int longestSubarray(List<Integer> arr) {
        int max = 0;
        Set<Integer> set = new HashSet<>();
        int i = 0;
        int j = 1;
        while (i < arr.size() - 1) {
            set.add(arr.get(i));
            while (j < arr.size() && Math.abs(arr.get(i) - arr.get(j)) < 2) {
                if (!set.contains(arr.get(j))) {
                    if (set.size() == 2) break;
                    else set.add(arr.get(j));
                }
                ++j;
            }
            max = Math.max(max, j - i);
            j = ++i + 1;
            set.clear();
        }
        return max;
    }

    public static List<String> mostActive(List<String> customers) {
        double threshold = ((double) customers.size()) / 20;
        Map<String, Long> traderShareMap = customers.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        List<String> mostActiveTraders = traderShareMap.entrySet().stream().filter(f -> f.getValue() >= threshold).map(m -> m.getKey()).collect(Collectors.toList());
        Collections.sort(mostActiveTraders);
        return mostActiveTraders;
    }

    public static long repeatedString(String s, long n) {
        long count = 0;
        List<Integer> aInStr = new ArrayList<>();
        int remainder = (int) (n % s.length());
        long quotient = n / s.length();
        for (int i = 0; i < s.length(); i++) {
            if (String.valueOf(s.charAt(i)).equals("a")) {
                if (i < remainder) count++;
                aInStr.add(i);
            }
        }
        count += quotient * aInStr.size();
        System.out.println(count);
        return count;
    }

    public static int jumpingOnClouds(List<Integer> c) {
        int count = 0;
        for (int i = 0; i < c.size(); i += 0) {
            int step2 = i + 2;
            int step1 = i + 1;
            if (c.size() > step2 && c.get(step2) == 0) {
                count += 1;
                i = step2;
            } else if (c.size() > step1 && c.get(step1) == 0) {
                count += 1;
                i = step1;
            } else {
                i++;
            }
        }
        return count;
    }

    public static int countingValleys(int steps, String path) {
        int valleys = 0;
        int count = 0;
        for (int i = 0; i < steps; i++) {
            if ("U".equals(String.valueOf(path.charAt(i)))) {
                count += 1;
                if (count == 0) valleys += 1;
            } else count -= 1;
        }
        return valleys;
    }

    public static int sockMerchant(int n, List<Integer> ar) {
        Map<Integer, Integer> intMap = new HashMap<>();
        System.out.println(ar);
        final int[] pairs = {0};
        ar.forEach(a -> {
            if (intMap.containsKey(a)) {
                intMap.put(a, intMap.get(a) + 1);
                if (intMap.get(a) % 2 == 0) pairs[0]++;
            } else intMap.put(a, 1);
        });
        return pairs[0];
    }

    private static void patterPrintingOptimised(int num) {
        int count = 0;
        int m = num;
        while (m != 0) {
            m = m / 10;
            count++;
        }
        while (count > 0) {
            System.out.println((int) (num % (Math.pow(10, count))));
            count--;
        }

    }

    private static void patterPrintingReverseOptimised(int num) {
        int count = 0;
        int m = num;
        while (m != 0) {
            m = m / 10;
            count++;
        }
        while (count > 0) {
            System.out.println((int) (num / (Math.pow(10, count - 1))));
            count--;
        }
    }

    private static void patterPrintingReverse(int num) {
        List<Integer> intList = convertIntToList(num);
        for (int i = 0; i < intList.size(); i++) {
            for (int j = 0; j <= i; j++) System.out.print(intList.get(j));
            System.out.println();
        }
    }

    private static List<Integer> convertIntToList(int num) {
        List<Integer> intList = new ArrayList<>();
        while (num != 0) {
            intList.add(num % 10);
            num = num / 10;
        }
        Collections.reverse(intList);
        return intList;
    }

    private static void getTimeZone(StringBuffer sb, String s) {
        sb.append("utkarsh");
        s = s + "utkarsh";
        System.out.println("---");
        System.out.println(s);
        System.out.println("---");
    }

//    private static void rainForest() {
//        String asin = "B073JYC4XM";
//        String url = "https://api.rainforestapi.com/request?api_key=73909849ACA44E38AEEBEE20D097C6DA&type=product&amazon_domain=amazon.com&asin=";
//        RestTemplate restTemplate = new RestTemplate();
//        Map response = restTemplate.getForObject(url + asin, Map.class);
//        Map product = (Map) response.get("product");
//        Map<String, Object> productDetails = new HashMap<>();
//        productDetails.put("category", product.get("categories"));
//        productDetails.put("image", product.get("main_image"));
//        productDetails.put("link", product.get("link"));
//        productDetails.put("description", product.get("description"));
//        System.out.println(productDetails);
//    }

    private static void wordDetect() {
        String[] filterWords = {"Bad", "Wrong", "Defective"};

        Scanner input = new Scanner(System.in);
        System.out.println("Enter Comment");

        String comment = input.nextLine();

        String regex = Stream.of(filterWords).map(Pattern::quote).collect(Collectors.joining("|", "(?i)\\b(?:", ")\\b"));
        if (Pattern.compile(regex).matcher(comment).find()) {
            System.out.println(comment + " is an Invalid Comment");
        } else {
            System.out.println(comment + " is a Valid Comment");
        }
    }

}
