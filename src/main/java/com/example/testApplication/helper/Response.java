package com.example.testApplication.helper;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@JacksonXmlRootElement(localName = "Response")
public class Response implements Serializable {

    @JacksonXmlProperty(isAttribute = true)
    private Long id;

    @JacksonXmlProperty(isAttribute = true)
    private LocalDateTime dts;

    @JacksonXmlProperty
    private Long p_id;

    @JacksonXmlProperty
    private int status;

    @JacksonXmlProperty
    private String message;

    public Response() {
    }

    public Response(Long id, Long p_id, int status, String message) {

        this.dts = LocalDateTime.now();
        this.p_id = p_id;
        this.status = status;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDts() {
        return dts;
    }

    public void setDts(LocalDateTime dts) {
        this.dts = dts;
    }

    public Long getP_id() {
        return p_id;
    }

    public void setP_id(Long p_id) {
        this.p_id = p_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Response other = (Response) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.dts, other.dts)) {
            return false;
        }

        return Objects.equals(this.id, other.id);
    }
}
