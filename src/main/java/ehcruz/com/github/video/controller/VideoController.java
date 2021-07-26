package ehcruz.com.github.video.controller;

import ehcruz.com.github.video.model.Video;
import ehcruz.com.github.video.service.VideoService;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("videos")
public class VideoController {

    @Inject
    private VideoService service;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllVideos() {
        var videos = service.findAll();
        return Response.ok().entity(videos).build();
    }

    @GET
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getVideoByAnId(@PathParam Long id) {
        var video = service.findVideo(id);
        return Response.ok(video).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createNewVideo(Video video) {
        return Response.ok(service.createVideo(video)).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateVideo(Video video) {
        return Response.ok(service.updateVideo(video)).build();
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteVideo(@PathParam Long id) {
        service.deleteVideo(id);
        return Response.ok().build();
    }
}
