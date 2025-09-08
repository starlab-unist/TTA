function parseMusic(musicString) {
    const noteMap = { 'o': 4, 'o|': 2, '.|': 1 };
    return musicString.split(' ').filter(x => x).map(x => noteMap[x]);
}