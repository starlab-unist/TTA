function extractNotes(musicalNotation) {
    const noteMapping = { 'o': 4, 'o|': 2, '.|': 1 };
    const notes = musicalNotation.split(' ');
    const result = [];

    for (let i = 0; i < notes.length; i++) {
        const note = notes[i];
        if (note) {
            result.push(noteMapping[note]);
        }
    }

    return result;
}