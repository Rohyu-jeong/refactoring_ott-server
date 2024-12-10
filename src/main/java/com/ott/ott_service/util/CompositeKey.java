package com.ott.ott_service.util;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class CompositeKey implements Serializable {
    private int movieId;
    private int entityId;

    @Override
    public boolean equals(Object object) {
        if(this == object) return true;
        if(!(object instanceof CompositeKey)) return false;

        CompositeKey compositeKey = (CompositeKey) object;
        return movieId == compositeKey.movieId && entityId == compositeKey.entityId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieId, entityId);
    }
}
