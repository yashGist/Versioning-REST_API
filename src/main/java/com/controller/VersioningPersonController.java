package com.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {
    //URI versioning used by TWITTER
    @GetMapping("/v1/person")
    public PersonV1 getFirstVersionOfPerson() {
        return new PersonV1("Bob Charlie");
    }
    //URI versioning used by TWITTER
    @GetMapping("/v2/person")
    public PersonV2 getSecondVersionOfPerson() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }

    //RequestParameter versioning used by AMAZON
    @GetMapping(path = "/person", params = "version=1")
    public PersonV1 getFirstVersionOfPersonRequestParameter() {
        return new PersonV1("Bob Charlie");
    }

    //RequestParameter versioning used by AMAZON
    @GetMapping(path = "/person", params = "version=2")
    public PersonV2 getSecondVersionOfPersonRequestParameter() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }


    //Custom Header versioning used by MICROSOFT
    @GetMapping(path = "/person/header", headers = "X-API-VERSION=1")
    public PersonV1 getSecondVersionOfPersonRequestHeader() {
        return new PersonV1("Bob Charlie");
    }

    //Custom Header versioning used by MICROSOFT
    @GetMapping(path = "/person/header", headers = "X-API-VERSION=2")
    public PersonV2 getFirstVersionOfPersonRequestHeader() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }

    //Media Type versioning a.k.a "content negotiation" or "accept header" used by GITHUB
    @GetMapping(path = "/person/accept", produces = "application/vdn.company.app-v1+json")
    public PersonV1 getFirstVersionOfPersonAcceptHeader() {
        return new PersonV1("Bob Charlie");
    }

    //Media Type versioning a.k.a "content negotiation" or "accept header" used by GITHUB
    @GetMapping(path = "/person/accept", produces = "application/vdn.company.app-v2+json")
    public PersonV2 getSecondVersionOfPersonAcceptHeader() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }

}

