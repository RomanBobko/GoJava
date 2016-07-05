package ua.goit.gojavaonline.core_3.groupe_02.bobko.module9;

import org.junit.Test;

import static org.junit.Assert.*;

public class CaesarChiperTest {
    @Test
    public void testEncryption() throws Exception {
        String source = "AbCd";
        assertEquals(CaesarChiper.encryption(source, 1), "BcDe");
    }

    @Test
    public void testDecryption() throws Exception {
        String source = "BcDe";
        assertEquals(CaesarChiper.decryption(source, 1), "AbCd");
    }

}