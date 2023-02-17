package com.viettelpost.scrape.ultils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private long id;
    private String studentName;
    private String email;
    private String mobileNo;
}
