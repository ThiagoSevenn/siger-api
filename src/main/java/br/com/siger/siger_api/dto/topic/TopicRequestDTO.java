package br.com.siger.siger_api.dto.topic;

public record TopicRequestDTO(Long topicId, Long meetingMinutesId, Long participantId,
                              String title, Integer timer, Integer orderIndex,
                              Boolean concluded, String priority) {
}
