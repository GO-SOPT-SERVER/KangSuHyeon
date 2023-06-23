package sopt.org.fourthSeminar.infrastructure;

import org.springframework.data.repository.Repository;
import sopt.org.fourthSeminar.domain.Image;

public interface ImageRepository extends Repository<Image, Long> {
    void save(Image image);
}
