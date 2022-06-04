package highcloud.IP001_PROJECT.filter;

//@Slf4j <- 더 공부해야될듯


import highcloud.IP001_PROJECT.domain.Member;
import org.springframework.util.PatternMatchUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {
    private static final String[] whitelist={"/", "/sign_in", "/sign_up"};

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String requestURI = httpRequest.getRequestURI();
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        try {
            if(isLoginCheckPath(requestURI)){
                HttpSession session = httpRequest.getSession();
                if((Member)session.getAttribute("member")==null){
                    httpResponse.sendRedirect("/");
                    return;
                }
            }
            chain.doFilter(request, response);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        } catch (ServletException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

    }

    private boolean isLoginCheckPath(String requestURI) {
        return !PatternMatchUtils.simpleMatch(whitelist, requestURI);
    }
}
