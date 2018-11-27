package com.uengine.education;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface Streams {

    @Output("class-topic")
    MessageChannel outboundChannel();

}
