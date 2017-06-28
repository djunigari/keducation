package nz.co.midori.backend.core.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by alexandreigari on 27/06/17.
 */
@ResponseStatus(HttpStatus.FORBIDDEN)
public final class ForbiddenException extends RuntimeException {
}
