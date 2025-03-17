package com.dreamteam.algorithm.analysis.domain.algorithm.encryption;

import com.dreamteam.algorithm.analysis.domain.algorithm.Algorithm;

public interface EncryptionAlgorithm extends Algorithm {
    byte[] encrypt(byte[] data, byte[] key);
    byte[] decrypt(byte[] data, byte[] key);
}
