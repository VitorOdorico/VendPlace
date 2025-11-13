package Utils;

import org.mindrot.jbcrypt.BCrypt;

public class CriptografiaUtil {

    public static String criptografar(String senha) {
        return BCrypt.hashpw(senha, BCrypt.gensalt(12));
    }

    public static boolean verificarSenha(String senhaDigitada, String senhaCriptografada) {
        if (senhaCriptografada == null || !senhaCriptografada.startsWith("$2a$")) {
            throw new IllegalArgumentException("Senha inválida ou formato incorreto");
        }
        return BCrypt.checkpw(senhaDigitada, senhaCriptografada);
    }
}
