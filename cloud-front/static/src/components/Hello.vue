<template>
  <div>
    <b-carousel id="carousel1"
                controls
                indicators
                background="#ababab"
                :interval="4000"
                v-model="slide"
                @slide="onSlide"
                @slid="onSlid"
    >

      <!-- Text slides with image -->
      <b-carousel-slide caption="First slide"
                        text="Nulla vitae elit libero, a pharetra augue mollis interdum."
                        img="https://lorempixel.com/1024/480/technics/2/"
      ></b-carousel-slide>

      <!-- Slides with custom text -->
      <b-carousel-slide img="https://lorempixel.com/1024/480/technics/4/">
        <h1>Hello world!</h1>
      </b-carousel-slide>

      <!-- Slides with image only -->
      <b-carousel-slide img="https://lorempixel.com/1024/480/technics/8/">
      </b-carousel-slide>

      <!-- Slides with img slot -->
      <b-carousel-slide>
        <img slot="img" class="d-block img-fluid"
             src="https://lorempixel.com/1024/480/technics/5/" alt="image slot">
      </b-carousel-slide>

      <!-- Slide with blank image to maintain aspect ratio -->
      <b-carousel-slide caption="Blank Image" :img="blankImg(1024,480)">
        <p>
          Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse
          eros felis, tincidunt a tincidunt eget, convallis vel est. Ut pellentesque
          ut lacus vel interdum. Nulla bibendum tincidunt erat, sed tincidunt
          magna finibus ac.
        </p>
      </b-carousel-slide>

    </b-carousel>
  </div>
</template>

<script>
  export default {
    data: function () {
      return {slide: 0};
    },
    methods: {
      blankImg(x, y) {
        // Return a blank SVG image with specified width and height
        // Handy for maintaining aspect ratio for text only slides
        return "data:image/svg+xml;charset=utf-8,%3Csvg xmlns%3D" +
          "'http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg' " +
          "viewBox%3D'0 0 " + x + " " + y + "'%2F%3E";
      },
      onSlide(slide) {
        this.sliding = true;
      },
      onSlid(slide) {
        this.sliding = false;
      }
    }
  }
</script>
<style>
  .img-fluid {
    width: 100%;
    height: 100%;
  }
</style>
