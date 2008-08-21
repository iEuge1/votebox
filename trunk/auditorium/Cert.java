/**
  * This file is part of VoteBox.
  * 
  * VoteBox is free software: you can redistribute it and/or modify
  * it under the terms of the GNU General Public License as published by
  * the Free Software Foundation, either version 3 of the License, or
  * (at your option) any later version.
  * 
  * VoteBox is distributed in the hope that it will be useful,
  * but WITHOUT ANY WARRANTY; without even the implied warranty of
  * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  * GNU General Public License for more details.
  * 
  * You should have received a copy of the GNU General Public License
  * along with VoteBox.  If not, see <http://www.gnu.org/licenses/>.
 */
package auditorium;

import sexpression.*;

/**
 * This class represents a certificate, which is essentially a signed key. Its
 * S-expression format is:
 * <p>
 * <tt>
 * (cert <br>
 * &nbsp;(signature <i>signer</i> <i>sig-data</i><br>
 * &nbsp;&nbsp;(key <i>id</i> <i>annotation</i> <i>mod</i> <i>exp</i>)))
 * </tt>
 * <p>
 * Note that the <tt>(signature...)</tt> subexpression is the S-expression
 * representation of a {@link Signature}; similarly, the <tt>(key...)</tt>
 * subexpression is a {@link Key}.
 * 
 * @see auditorium.Signature
 * @see auditorium.Key
 * @author kyle
 */
public class Cert {

    public static final ASExpression PATTERN = new ListExpression(
            StringExpression.makeString( "cert" ), Wildcard.SINGLETON );

    private final Signature _signature;
    private final Key _key;

    /**
     * @param sig
     *            This is the signature
     * @throws IncorrectFormatException
     */
    public Cert(Signature sig) throws IncorrectFormatException {
        _signature = sig;
        _key = new Key( sig.getPayload() );
    }

    /**
     * Construct a certificate from its s-expression format.
     * 
     * @param cert
     *            This is the certificate message in its s-expression format.
     * @throws IncorrectFormatException
     *             This method throws if the given expression isn't formatted
     *             like PATTERN.
     */
    public Cert(ASExpression cert) throws IncorrectFormatException {
        ASExpression matchresult = PATTERN.match( cert );
        if (matchresult == NoMatch.SINGLETON)
            throw new IncorrectFormatException( cert, new Exception(
                    "given expression did not match the pattern" ) );
        ListExpression matchlist = (ListExpression) matchresult;

        _signature = new Signature( matchlist.get( 0 ) );
        _key = new Key( _signature.getPayload() );
    }

    /**
     * Convert this certificate to its auditorium s-expression format.
     * 
     * @return This method returns (cert (signature [signer] [)
     * @throws CertificateEncodingException
     *             THis method throws if the certificate cannot be encoded.
     */
    public ListExpression toASE() {
        return new ListExpression( StringExpression.makeString( "cert" ),
                _signature.toASE() );
    }

    /**
     * @return This method returns the signature structure that makes up this
     *         cert.
     */
    public Signature getSignature() {
        return _signature;
    }

    /**
     * @return This method returns the key that this certificate presents.
     */
    public Key getKey() {
        return _key;
    }
}
