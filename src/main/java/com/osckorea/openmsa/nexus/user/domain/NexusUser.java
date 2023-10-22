package com.osckorea.openmsa.nexus.user.domain;

import lombok.*;


@Builder
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class NexusUser {
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String external;
}
