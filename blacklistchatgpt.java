import java.io.*; //input & output bf
import java.math.*; // for Operation
import java.security.*; //security reason 
import java.text.*; 
import java.util.*;
import java.util.concurrent.*; //With thread version of collection 
import java.util. function.*; //lambda expression 
 import java.util.regex.*;//Pattern matches
import java.util.stream.*; // data in a functional and declarative stylelike mapping, collection,
import static java.util.stream.Collectors.joining; // joining method from the Collectors class 
import static java.util.stream.Collectors.toList; //you can use the toList method directly in your code without having to prefix it with Collectors

class Result {
    public static List<Integer> validateRequest(List<String> blacklistedIps, List<String> requests) {
        List<Integer> blockedRequests = new ArrayList<>();
        Map<String, Integer> ipCount = new HashMap<>();

        for (String request : requests) {
            boolean blocked = false;

            // Check if the request matches any blacklisted regex IP
            for (String regexIp : blacklistedIps) {
                String pattern = regexIp.replace(".", "\\.").replace("*", ".*");
                if (Pattern.matches(pattern, request)) {
                    blocked = true;
                    break;
                }
            }

            // Extract the IP address
            String[] parts = request.split("\\.");
            String ip = parts[0];

            // Check if the IP address has sent at least 2 requests in the last 5 seconds
            if (ipCount.containsKey(ip)) {
                if (ipCount.get(ip) >= 2) {
                    blocked = true;
                } else {
                    ipCount.put(ip, ipCount.get(ip) + 1);
                }
            } else {
                ipCount.put(ip, 1);
            }

            // Add the result to the list
            blockedRequests.add(blocked ? 1 : 0);

            // Remove IPs from the map that are older than 5 seconds
            List<String> keysToRemove = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : ipCount.entrySet()) {
                if (entry.getValue() > 1) {
                    ipCount.put(entry.getKey(), entry.getValue() - 1);
                } else {
                    keysToRemove.add(entry.getKey());
                }
            }
            for (String key : keysToRemove) {
                ipCount.remove(key);
            }
        }

        return blockedRequests;
    }
}

class Solution {
public static void main(String[] args) throws IOException {
BufferedReader bufferedReader = new BufferedReader (new InputStreamReader (System. in)) ;
//System.out.println(System. getenv ("OUTPUT_PATH"));
BufferedWriter bufferedWriter = new BufferedWriter (new FileWriter (System. getenv ("OUTPUT_PATH") )) ;
int blacklisted_ipsCount = Integer.parseInt (bufferedReader.readLine ().trim() );
List<String> blacklisted_ips = IntStream.range(0, blacklisted_ipsCount).mapToObj (i -> {
try {
return bufferedReader. readLine() ;
} catch (IOException ex) {
throw new RuntimeException (ex) ;
}
})
.collect (toList ());
int requestsCount = Integer.parseInt (bufferedReader. readLine().trim ()) ;
List<String> requests = IntStream. range (0, requestsCount) .mapToObj(i -> {
try {
return bufferedReader. readLine () ;
} catch (IOException ex) {
throw new RuntimeException (ex) ;
}
})
.collect (toList ());
List<Integer> result = Result.validateRequests (blacklisted_ips, requests) ;
bufferedWriter.write( result.stream ()
   .map(Object::toString)
   .collect(joining("\n"))
   +"\n"
);
bufferedReader.close(); 
bufferedWriter.close();
}
}