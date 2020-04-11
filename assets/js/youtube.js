let tag = document.createElement('script');

tag.src = "https://www.youtube.com/iframe_api";
var firstScriptTag = document.getElementsByTagName('script')[0];
firstScriptTag.parentNode.insertBefore(tag, firstScriptTag);

let players = {};
function onYouTubeIframeAPIReady() {
    let iframes = document.getElementsByTagName('iframe');
    for (let i = 0; i < iframes.length; i++) {
        let iframe = iframes[i];
        players[iframe.id] = new YT.Player('iframe.id');
    }
}


window.addEventListener('DOMContentLoaded', function() {
    console.log('here');
    let links = document.getElementsByTagName("a");
    for (let i = 0; i < links.length; i++) {
        let link = links[i];
        let id_and_time = link.href;
        if (id_and_time[0] !== 'y')
            continue;
        let id_time = id_and_time.split('#');
        let id = id_time[1];
        let time = id_time[2].split(':');
        console.log('link', link);
        link.addEventListener('click', function(e) {
            console.log('click', id, players);
            players[id].seekTo(time[0]*60 + time[1], true);
            e.preventDefault();
        });
    }
});
