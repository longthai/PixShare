/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;


import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import model.User;

/**
 * REST Web Service
 *
 * @author Admin
 */
@Path("user")
public class UserResource {

    @Context
    private UriInfo context;
    
    @EJB
    private ManageUser mu;

    /**
     * Creates a new instance of UserResource
     */
    public UserResource() {
    }

    /**
     * Retrieves representation of an instance of EJB.UserResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    @Context
        private HttpServletRequest request;
    @POST
    @Path("login")
    @Produces(MediaType.APPLICATION_JSON)
    public User login(@FormParam("nickname") String nick, @FormParam("password") String pwd){
        
        User u = mu.checkLoginStatus(new User(nick,pwd));
        if(null == u) {
            
            return null;
            
        } else {    
        HttpSession session = request.getSession(true);
        session.setAttribute("password", u.getPassword());
        session.setAttribute("username", u.getUsername());
        session.setAttribute("userid", u.getId());
        return u;
        }
    }
    
    @POST
    @Path("create")
    @Produces(MediaType.APPLICATION_JSON)
    public User create(@FormParam("fullname") String full,  @FormParam("nickname") String nick, @FormParam("password") String pwd){ 
        User u = new User(nick, full, pwd);
        if(mu.checkExistUser(u)){
            return null;
        }
        return mu.addUser(u);
    }
    
    @POST
    @Path("logout")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean logOut() {
       try{
           HttpSession session = request.getSession();
           session.invalidate();
           return true;
       } catch(Exception pokemon){}
       return false;
   }
}
