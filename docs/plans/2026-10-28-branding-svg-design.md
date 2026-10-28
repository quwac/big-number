# Branding SVG design

## Goal

Replace raster-first branding with reusable SVG assets while preserving the original layered gradients and letter shapes.

## Logo

- Use a 1280×640 transparent canvas for GitHub repository cards.
- Keep all visible artwork inside the 80 px safe area.
- Represent `Big` and `Number` entirely with paths; do not reference fonts or raster images.
- Preserve the four gradient bands in `B` and the layered transitions in `i` and `g`.

## Project icon

- Preserve the square 1254×1254 transparent canvas and the four-band `B` treatment.
- Rebuild `N` from its inner glyph outline and fill it with the same dark navy used by `Number`.
- Keep the SVG and PNG variants visually aligned, and use the same SVG for the IDE project icon.

## Verification

- Parse both SVG files as XML and render them to PNG.
- Confirm the SVG files contain no `text`, `image`, font, or external-reference elements.
- Compare the rendered assets against the approved previews on white and transparent backgrounds.
