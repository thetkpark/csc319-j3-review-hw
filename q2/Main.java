package q2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Album> albums = new ArrayList<>();
        albums.add(SampleData.aLoveSupreme);
        albums.add(SampleData.manyTrackAlbum);
        albums.add(SampleData.sampleShortAlbum);

        // Using the original code
//        System.out.println("\n----Traditional----");
        Set<String> longTracName = findLongTracks(albums);
        printFromListString(longTracName);
    }

    public static void printFromListString(Set<String> l) {
        for(String str : l) System.out.println(str);
    }

//    public static Set<String> findLongTracks(List<Album> albums) {
//        Set<String> trackNames = new HashSet<>();
//        for(Album album : albums) {
//            for (Track track : album.getTrackList()) {
//                if (track.getLength() > 60) {
//                    String name = track.getName();
//                    trackNames.add(name);
//                }
//            }
//        }
//        return trackNames;
//    }

    public static Set<String> findLongTracks(List<Album> albums) {
        return albums.stream() // Stream<Album>
                .flatMap(Album::getTracks) // Stream<Track>
                .filter(track -> track.getLength() > 60) // Stream<Track>
                .map(Track::getName) // Stream<String>
                .collect(Collectors.toSet()); // Set<String>
    }
}
