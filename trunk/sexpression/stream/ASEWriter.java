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
package sexpression.stream;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import sexpression.ASExpression;

/**
 * The ASEWriter can take an ASExpressions and serialize them over an output
 * stream.
 * 
 * @author Kyle
 * 
 */
public class ASEWriter {

    private OutputStream _stream;
    private OutputStream _base64Stream;

    /**
     * @param out
     *            This is the stream that ASExpressions will get written to.
     */
    public ASEWriter(OutputStream out) {
        _stream = out;
        _base64Stream = new Base64.OutputStream( out );
    }

    /**
     * Invoke this method to serialize an ASExpression to the decorated output
     * stream in the verbatim format.
     * 
     * @param expression
     *            This is the ASExpression that will get serialized.
     * @throws UnsupportedEncodingException
     *             This method throws if US-ASCII isn't supported on the
     *             platform. S-Expressions, internally, are kept as Java unicode
     *             strings. The spec for S-Expression, however, states that the
     *             canonical form is to be a byte-string using ASCII character
     *             encoding. For this reason, the platform needs to know about
     *             US-ASCII so that it can convert the string properly.
     * @throws IOException
     *             This method throws if the decorated stream's write method
     *             throws.
     * @throws IncorrectUseException
     *             This method throws if the given expression cannot be
     *             converted to a verbatim expression.
     */
    public void writeASE(ASExpression expression) throws IOException {
        _stream.write( expression.toVerbatim() );
        _stream.flush();
    }

    /**
     * Invoke this method to serialize an ASExpression to the decorated output
     * strea in the base64 canonical/verbatim format.
     * 
     * @param expression
     *            Write this expression to the stream.
     * @throws IOException
     *             This method throws if the wrapped stream throws an
     *             IOException.
     * @throws IncorrectUseException
     *             This method throws if the given expression cannot be
     *             converted to a verbatim expression.
     */
    public void writeASE64(ASExpression expression) throws IOException {
        final int openbrace = new String( "{" ).getBytes( "us-ascii" )[0];
        final int closebrace = new String( "}" ).getBytes( "us-ascii" )[0];

        _stream.write( openbrace );
        _base64Stream.write( expression.toVerbatim() );
        _stream.write( closebrace );
        _stream.flush();
    }
}
