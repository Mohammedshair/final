package com.example.qrscannerbackend;

import org.springframework.web.bind.annotation.*;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ScanController {

    private Set<String> entrySet = new HashSet<>();

    @GetMapping("/checkUSN")
    public String checkUSN(@RequestParam String usn) {

        if (usn.toUpperCase().startsWith("NNM24AM")) {
            int num = Integer.parseInt(usn.substring(8));
            if (num >= 1 && num <= 80) {

                if (entrySet.contains(usn)) {
                    return "Already Entered ⚠️";
                }

                entrySet.add(usn);
                return "Entry Recorded ✔";
            }
        }

        return "Not Allowed ❌";
    }
}
