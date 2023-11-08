package com.tourbooking.service.image;

import com.tourbooking.repository.image.IImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService implements IImageService{
    @Autowired
    private IImageRepository imageRepository;
    @Override
    public void deleteById(int id) {
        imageRepository.deleteImageByTourId(id);
    }
}
