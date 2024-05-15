package org.louis.backend.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GitHubUser {


    private String login;
    private String id;
    private String avatar_url;
    private String url;
    private String name;
    private String location;


}
