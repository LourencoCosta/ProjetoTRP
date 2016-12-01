import com.sun.org.apache.xerces.internal.parsers.SecurityConfiguration

// Place your Spring DSL code here
beans = {
    webSecurityConfiguration(SecurityConfiguration)

//    redirectFailureHandlerExample(SimpleUrlAuthenticationFailureHandler) {
//        defaultFailureUrl = '/failed' //redirect to this URL when authentication fails
//    }
}
