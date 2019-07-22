package lttzz.ch8.exp1;

import javax.servlet.*;
import java.io.IOException;

public class EncodingFilter implements Filter {

    protected String encoding = null;
    protected FilterConfig config;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.config = filterConfig;
        // read form web.xml
        this.encoding = filterConfig.getInitParameter("encoding");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        if (req.getCharacterEncoding() == null) {
            String encode = getEncoding();
            if (encode != null) {
                req.setCharacterEncoding(encode);
                resp.setCharacterEncoding(encode);
            }
        }
        filterChain.doFilter(req, resp);
    }

    public String getEncoding() {
        return encoding;
    }

    @Override
    public void destroy() {

    }
}
