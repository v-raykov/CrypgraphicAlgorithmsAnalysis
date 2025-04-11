package com.dreamteam.algorithm.analysis.domain.algorithm.impl.encryption;

import com.dreamteam.algorithm.analysis.domain.algorithm.key.size.MultipleFixedKeySizes;
import lombok.Getter;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.engines.SerpentEngine;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Getter
public class Serpent extends EncryptionAlgorithm implements MultipleFixedKeySizes {
    private final List<Integer> keySizes = List.of(16, 24, 32);
    private final int ivSize = 16;

    private final BlockCipher engine = new SerpentEngine();

    @Override
    public boolean isValidKeySize(int keySize) {
        return keySizes.contains(keySize);
    }
}

