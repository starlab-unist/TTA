function extractNotes(musicalNotation) {
    const noteMapping = { 'o': 4, 'o|': 2, '.|': 1 };
    const notes = musicalNotation.split(' ');
    const result = [];

    for (let note of notes) {
        if (note) {
            result.push(noteMapping[note]);
        }
    }

    return result;
}