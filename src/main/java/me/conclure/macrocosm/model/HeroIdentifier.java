package me.conclure.macrocosm.model;

import java.time.Instant;
import java.util.random.RandomGenerator;

public record HeroIdentifier(int id) {

    public static HeroIdentifier generate(Instant instant, RandomGenerator random) {
        String id = String.valueOf(instant) + random.nextInt();
        return new HeroIdentifier(Integer.parseInt(id));
    }

    public int hashCode() {
        return this.id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HeroIdentifier that = (HeroIdentifier) o;
        return id == that.id;
    }
}