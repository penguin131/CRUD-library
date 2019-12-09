$(".butt").dblclick(function () {
    const t = $(this).find(".field");
    t.get(0).slideToggle();
});