package radius.Converters;

import radius.Adapters.RoleAdapter;
import radius.Service.RadiusService;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 * Created by rozerin on 14.09.2015.
 */
@ManagedBean
@RequestScoped
public class RoleConverter implements Converter {


    @ManagedProperty("#{radiusService}")
    private RadiusService service;

    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        RoleAdapter tmprole = service.getRoleById(Integer.parseInt(value));
        return tmprole;
    }

    public String getAsString(FacesContext context, UIComponent component, Object value) {
        RoleAdapter tmprole = (RoleAdapter) value;
        return tmprole.getRoleId() + "";
    }

    public RadiusService getService() {
        return service;
    }

    public void setService(RadiusService service) {
        this.service = service;
    }
}
